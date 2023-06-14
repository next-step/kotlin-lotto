package com.nextstep.second.calculator

object Calculator {
    fun add(numList: List<Int>): Int {
        return numList.fold(0) { acc, i -> acc + i };
    }
}