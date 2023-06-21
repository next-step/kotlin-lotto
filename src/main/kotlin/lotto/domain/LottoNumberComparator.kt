package lotto.domain

class LottoNumberComparator {
    companion object {
        fun compare(firstList: List<Int>, secondList: List<Int>): Boolean {
            return firstList.toSet() == secondList.toSet()
        }
    }
}
