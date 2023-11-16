package specific.lotto.domain

import hasDuplicate
import isSortedAsc


data class LottoNumber(val values: List<Int>) {
    init {
        require(values.all { it in 1..45 }) { "'values' must be from 1 to 45" }
        require(!values.hasDuplicate()) { "'values' must not contain duplicate numbers" }
        require(values.isSortedAsc()) { "'values' must be an ascending ordered number" }
        require(values.size == 6) { "'values' must be 6 numbers" }
    }
}
