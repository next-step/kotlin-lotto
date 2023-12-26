package camp.nextstep.edu.step.step2.dto

data class LottoProcessDto(
    val manualTicketAmount: Int,
    val autoTicketAmount: Int,
    val lottoTicketList: List<List<Int>>,
)
