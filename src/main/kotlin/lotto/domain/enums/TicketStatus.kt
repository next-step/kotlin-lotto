package lotto.domain.enums

enum class TicketStatus {
    INIT, ISSUE;

    fun isInit(): Boolean = this == INIT
}
