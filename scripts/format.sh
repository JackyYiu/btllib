#!/bin/bash

if [ -z "${MESON_SOURCE_ROOT}" ]; then
    echo "[ERROR] This script can only be ran with meson!"
    exit 1
fi

cd "${MESON_SOURCE_ROOT}"

set -e
files=$(scripts/get_include_files.sh)
for file in $files; do
    diff $file <(clang-format -style=mozilla $file)
done