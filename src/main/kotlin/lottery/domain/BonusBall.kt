package lottery.domain

class BonusBall(val number: Int, winnerLottery: WinnerLottery) {
    init {
        require(!winnerLottery.contains(number)) { "보너스 볼은 당첨 번호에 포함될 수 없습니다." }
    }
}
