package lotto.domain

class LottoNumberComparator {
    companion object {
        fun compare(firstList: List<LottoNumber>, secondList: List<LottoNumber>): Int {
            return firstList.toSet().intersect(secondList.toSet()).size
        }
    }
}
