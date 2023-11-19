package lotto.data

enum class LottoRanking(val matchingNumberCnt: Int, val price: Int) : Prize {
    FirstPlace(6, 2_000_000_000) {
        override fun findPrize(winningStatus: Pair<LottoRanking, Int>): Int {
            return winningStatus.first.price * winningStatus.second
        }
    },
    SecondPlace(5, 30_000_000) {
        override fun findPrize(winningStatus: Pair<LottoRanking, Int>): Int {
            return winningStatus.first.price * winningStatus.second
        }
    },
    ThirdPlace(5, 1_500_000) {
        override fun findPrize(winningStatus: Pair<LottoRanking, Int>): Int {
            return winningStatus.first.price * winningStatus.second
        }
    },
    FourthPlace(4, 50_000) {
        override fun findPrize(winningStatus: Pair<LottoRanking, Int>): Int {
            return winningStatus.first.price * winningStatus.second
        }
    },
    FifthPlace(3, 5_000) {
        override fun findPrize(winningStatus: Pair<LottoRanking, Int>): Int {
            return winningStatus.first.price * winningStatus.second
        }
    },
    None(0, 0) {
        override fun findPrize(winningStatus: Pair<LottoRanking, Int>): Int {
            return winningStatus.first.price * winningStatus.second
        }
    };
}

fun interface Prize {
    fun findPrize(winningStatus: Pair<LottoRanking, Int>): Int
}
