package lotto


fun main() {
    println("구입 금액을 입력해 주세요.")
    val purchasePrice: Int = (readLine() ?: "0").toInt()

    val machine = Machine(purchasePrice)

    println("${machine.lottoCount}개를 구매했습니다.")
    println(machine.lottoList.joinToString { "\n${it.numbers}" })
    println("지난 주 당첨 번호를 입력해 주세요.")
    val winningValue = readLine()

    requireNotNull(winningValue)

    println("당첨 통계")

    machine.run(winningValue)

    val statistics = Statistics(machine.lottoResultList, purchasePrice).apply {
        this.run()
    }

    statistics.items.forEach {
        println("${it.prize.machCount}개 일치 ${it.standardPrize}원 (${it.machLottoCount})개")
    }

    println("총 수익률은 ${statistics.totalEarnings}입니다")
}
