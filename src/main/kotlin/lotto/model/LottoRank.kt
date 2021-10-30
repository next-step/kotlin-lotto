package lotto.model

/**
 * 로또 등수와 상금 정리한 클래스
 * */
enum class LottoRank(val countOfMatch: Int, val winningMoney: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    MISS(0, 0);

   companion object {
       fun compareMatchRank(number: Int): LottoRank {
           return values().find { it.countOfMatch == number } ?: MISS
       }
   }
}
