package lotto

import IssueStrategy

object LottoCreator {

    fun issue(strategy: IssueStrategy): List<LottoTicket> {
        return strategy.issue()
    }

    fun createLottoTickets(userInputNumber: List<String>): List<LottoTicket> {
        return userInputNumber.map {
            LottoTicket(formattedNumbers(it))
        }
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
