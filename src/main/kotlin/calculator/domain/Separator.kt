package calculator.domain

import calculator.constants.Messages

/**
 * 구분자를 저장하는 클래스
 * Created by Jaesungchi on 2022.05.21..
 */
data class Separator(val value: String) {
    init {
        require(isNotHaveNumber(value)) { Messages.SEPARATE_HAVE_NUMBER }
    }

    private fun isNotHaveNumber(value: String): Boolean {
        return value.none { it.isDigit() }
    }
}
