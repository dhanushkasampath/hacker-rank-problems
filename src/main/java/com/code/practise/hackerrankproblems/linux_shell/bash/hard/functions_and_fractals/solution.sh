#!/usr/bin/env bash

declare -A canvas
declare -i iterations
declare -i width=100
declare -i height=63

fill_canvas() {
    declare -i x y
    for ((y = 0; y < height; y++)); do
        for ((x = 0; x < width; x++)); do
            canvas[$y, $x]="_"
        done
    done
}

draw_point() {
    declare -i x y
    x="$1"
    y="$2"
    canvas[$y, $x]="1"
}

draw_trunk() {
    declare -i iteration trunk_height x0 y y0
    x0="$1"
    y0="$2"
    iteration="$3"
    ((iteration == iterations)) && return
    trunk_height=$((2 ** (4 - iteration)))

    for ((y = y0; y > y0 - trunk_height; y--)); do
        draw_point "$x0" "$y"
    done

    draw_branches "$x0" $((y0 - trunk_height)) $iteration
}

draw_branches() {
    declare -i branch_height d iteration x x0 y y0
    x0="$1"
    y0="$2"
    iteration="$3"
    branch_height=$((2 ** (4 - iteration)))

    for ((d = 1, y = y0; d <= branch_height; d++, y--)); do
        draw_point $((x0 - d)) "$y"
        draw_point $((x0 + d)) "$y"
    done

    draw_trunk $((x0 - branch_height)) $((y0 - branch_height)) $((iteration + 1))
    draw_trunk $((x0 + branch_height)) $((y0 - branch_height)) $((iteration + 1))
}

draw_tree() {
    fill_canvas
    draw_trunk $((width / 2 - 1)) $((height - 1)) 0
}

show_canvas() {
    declare -i x y
    for ((y = 0; y < height; y++)); do
        for ((x = 0; x < width; x++)); do
            printf '%s' "${canvas[$y, $x]}"
        done
        echo
    done
}

main() {
    read -r iterations
    draw_tree
    show_canvas
}

main "$@"