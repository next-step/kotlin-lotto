package lotto

import IssueStrategy

object LottoCreator {

    fun issue(strategy: IssueStrategy): LottoTickets {
        return strategy.issue()
    }

    fun createLottoTickets(userInputNumber: List<String>): LottoTickets {
        val factory = LottoTicketFactory()
        return LottoTickets(
            userInputNumber.map {
                factory.createDirectLottoTicket(formattedNumbers(it))
            }
        )
    }

    private fun formattedNumbers(list: String): List<LottoNumber> {
        return list.replace(SPACE_STRING, EMPTY_STRING).split(DELEMETER).map {
            LottoNumber(it.toInt())
        }
    }

    private const val DELEMETER = ","
    private const val SPACE_STRING = " "
    private const val EMPTY_STRING = ""
}
