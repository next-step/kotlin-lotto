package lotto.domain.rank

enum class BonusCondition(val match: (Boolean) -> Boolean) {
    NEED_MATCH({ it }),
    NEED_NOT_MATCH({ !it }),
    NO_MATTER({ true })
    ;
}
