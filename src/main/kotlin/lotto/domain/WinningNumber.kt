package lotto.domain

/**
 * 당첨 번호를 갖고, 당첨 여부를 알려주는 클래스.
 * Created by Jaesungchi on 2022.05.25..
 */
class WinningNumber(stringWinningNumber: String) {
    val winningNumber: List<Int>

    init {
        winningNumber = stringWinningNumber.split(",").map {
            it.trim().toInt()
        }
    }
}
