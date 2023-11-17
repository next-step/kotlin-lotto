package lotto.data

enum class LottoRanking(val matchingNumberCnt: Int, val price: Int) : Prize {
    FirstPlace(6, 2000000000) {
        override fun findPrize(winningStatus: Pair<LottoRanking, Int>): Int {
            return winningStatus.first.price * winningStatus.second
        }
    },
    SecondPlace(5, 1500000) {
        override fun findPrize(winningStatus: Pair<LottoRanking, Int>): Int {
            return winningStatus.first.price * winningStatus.second
        }
    },
    ThirdPlace(4, 50000) {
        override fun findPrize(winningStatus: Pair<LottoRanking, Int>): Int {
            return winningStatus.first.price * winningStatus.second
        }
    },
    FourthPlace(3, 5000) {
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

interface Prize {
    fun findPrize(winningStatus: Pair<LottoRanking, Int>): Int
}
