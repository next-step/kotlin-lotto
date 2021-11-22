package lotto

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class WinningLottoTest {

    @ParameterizedTest
    @ValueSource(strings = ["1, 3, 10, 11, 43, 32", "2, 3, 4, 10, 15, 41"])
    fun `지난 주 로또 번호 입력시(1~45) 에 맞춰 올바르게 입력하고 생성되는지 `(lottoNumber: String) {
    }

    @ParameterizedTest
    @ValueSource(strings = ["1, 3, 10, 11, 43, 32", "2, 3, 4, 10, 15, 41"])
    fun `지난 주 로또 번호를 순서대로 입력안해도 오름차순으로 정렬되는지 테스트 합니다`(lottoNumber: String) {
    }

    @ParameterizedTest
    @ValueSource(strings = ["3, 9, 23, 35, 41, 44"])
    fun `지난주 로또 번호에 이번주 구매한 로또 번호가 존재하는지 확인하는 함수를 테스트 합니다`(lottoNumber: String) {
    }

    @ParameterizedTest
    @ValueSource(strings = ["1, 3 ,10, 11, 41", "1, 3"])
    fun `지난 주 로또 번호가 6개가 아닐경우 IllegalArgumentException 예외가 발생한다`(lottoNumber: String) {
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1, 3, 10, 20 , 43, 45", "1, 32, 38, 41, 44, 50"])
    fun `지난 주 로또 번호 입력시 (1~45) 에 포함 되어 있지 않을 경우 IllegalArgumentException 예외가 발생한다`(lottoNumber: String) {
    }

    @ParameterizedTest
    @ValueSource(strings = ["1, 1, 45, 32, 31, 22"])
    fun `지난 주 로또 번호가 중복되었다면 개수가 부족하여 IllegalArgumentException 예외가 발생한다`(lottoNumber: String) {
    }
}
