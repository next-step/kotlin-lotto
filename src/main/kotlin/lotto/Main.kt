package lotto

fun main() {
    println("구입 금액을 입력해 주세요.")
    val money = readln().toInt()
    val lottoMachine = LottoMachine()
    val lottoTicket = lottoMachine.generateTicket(money)
    println("${lottoTicket.size} 개 구매했습니다")
    lottoTicket.lottos.map { lotto ->
        lotto.numbers.map { it.value }
    }.forEach {
        println(it)
    }

    println("지난 주 당첨 번호를 입력해 주세요.")
    val winningNumbers = readln()
    val winningLotto = lottoMachine.toWinningLotto(winningNumbers)

    val matches = lottoTicket.match(winningLotto)
    println("당첨 통계")
    println("---------")
    Match.values().forEach {
        println("${it.count}개 일치 (${it.winningAmount}원) - ${matches.count { match -> match == it }}개")
    }
}
