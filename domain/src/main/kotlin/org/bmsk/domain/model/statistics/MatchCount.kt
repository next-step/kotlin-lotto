package org.bmsk.domain.model.statistics

enum class MatchCount(val count: Int) {
    ZERO(0), THREE(3), FOUR(4), FIVE(5), SIX(6);

    companion object {
        fun from(value: Int) = values().firstOrNull { it.count == value } ?: ZERO
    }
}



