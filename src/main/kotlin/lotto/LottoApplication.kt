package lotto

fun main() {
    // Todo 1: 구입금액 입력 받기
    println("구입금액을 입력해 주세요.")
    val purchaseAmount = readln()

    // Todo 2: 몇개 구입했는지 출력
    val lottoGame = LottoGame(purchaseAmount.toInt())

    // Todo 3: 각 게임 결과 출력
    lottoGame.start()
    println(lottoGame.ticketQuantity.toString() + "개를 구매했습니다.")
    lottoGame.getAllLottoNumbers().forEach { println(it) }

    // Todo 4: 지난 주 당첨 번호 입력 받기


    // Todo 5: 당첨 통계 출력


    // Todo 6: 수익률 출력


}
