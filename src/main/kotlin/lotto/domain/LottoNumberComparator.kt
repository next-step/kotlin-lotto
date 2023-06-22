package lotto.domain

class LottoNumberComparator {
    companion object {
        fun compare(firstList: List<Int>, secondList: List<Int>): Int {
            return firstList.toSet().intersect(secondList.toSet()).size
        }
    }
}
