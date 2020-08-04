package com.nextstep.stringcalculator.utils

fun String.split(splits: List<String>): List<String> {
    return this.split(*splits.toTypedArray())
}
