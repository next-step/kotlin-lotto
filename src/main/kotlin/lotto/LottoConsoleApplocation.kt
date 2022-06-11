package lotto

fun main() {
    println("구입금액을 입력해 주세요.")
    val inputMoney: String = readln()
    require(inputMoney.isNotBlank()) { "구매금액 입력은 빈 값이나 공백이 될 수 없습니다." }
    val lottoPurchaseAmount =
        Money(inputMoney.toIntOrNull() ?: throw IllegalArgumentException("로또 구매 금액은 정수를 입력해야합니다."))
    println("${lottoPurchaseAmount.lottoTicketCount()}개를 구매했습니다.")
    val lottoTickets: LottoTickets = LottoFactory.auto(lottoPurchaseAmount.lottoTicketCount())
    lottoTickets.forEach() { lottoTicket ->
        println(lottoTicket.lottoNumbers.map { it.value }.joinToString(prefix = "[", postfix = "]"))
    }
    println()
    println("지난 주 당첨 번호를 입력해 주세요.")
    val inputWinningNumbers = readln()
    val winningTicket = LottoTicket(
        inputWinningNumbers.split(", ").toList()
            .map { LottoNumber.of(it.toIntOrNull() ?: throw IllegalArgumentException("")) }.toSet()
    )
    val lottoPrizes: LottoResults = LottoManager.winningConfirmation(lottoTickets, winningTicket)
    println()
    println("당첨 통계")
    println("---------")
    println("3개 일치 (5000원)- ${lottoPrizes.fourthPlaceCount}개")
    println("4개 일치 (50000원)- ${lottoPrizes.thirdPlaceCount}개")
    println("5개 일치 (1500000원)- ${lottoPrizes.secondPlaceCount}개")
    println("6개 일치 (2000000000원)- ${lottoPrizes.firstPlaceCount}개")
    println(String.format("총 수익률은 %.2f입니다.", lottoPrizes.totalPrize.toFloat() / lottoPurchaseAmount.value.toFloat()))
}
