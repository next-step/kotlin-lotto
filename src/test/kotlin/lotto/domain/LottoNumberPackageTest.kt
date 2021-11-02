package lotto.domain

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class LottoNumberPackageTest {

    @ParameterizedTest
    @MethodSource("getInvalidSizeOfLottoNumbers")
    fun `번호를 6개 입력하지 않았을 경우 IllegalArgumentException이 발생한다`(numbers: List<Int>) {
        Assertions.assertThatThrownBy {
            LottoNumberPackage(numbers.map { LottoNumber[it] }.toSet())
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    private fun getInvalidSizeOfLottoNumbers(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(listOf(1)),
            Arguments.of(listOf(1, 2)),
            Arguments.of(listOf(1, 2, 3)),
            Arguments.of(listOf(1, 2, 3, 4)),
            Arguments.of(listOf(1, 2, 3, 4, 5)),
            Arguments.of(listOf(1, 2, 3, 4, 5, 6, 7))
        )
    }

    @ParameterizedTest
    @MethodSource("getValidSizeOfLottoNumbers")
    fun `번호를 6개 입력 했을 경우 정상적으로 LottoNumberPackage가 생성된다`(numbers: List<Int>) {
        val lottoNumberPackage = LottoNumberPackage(numbers.map { LottoNumber[it] }.toSet())

        assertThat(lottoNumberPackage).isNotNull
        assertThat(lottoNumberPackage.size()).isEqualTo(LottoNumberPackage.LOTTO_GAME_NUMBER_COUNT)
    }

    private fun getValidSizeOfLottoNumbers(): Stream<Arguments> {
        return Stream.of(Arguments.of(listOf(1, 2, 3, 4, 5, 6)))
    }

    @ParameterizedTest
    @MethodSource("getUnsortedLottoNumbers")
    fun `정렬 되지 않은 번호번호로 LottoNumberPackage 를 생성한 후 getSortedNumbers()를 호출하면 정렬된 번호를 얻을 수 있다`(numbers: List<Int>) {
        val lottoNumberPackage = LottoNumberPackage(numbers.map { LottoNumber[it] }.toSet())

        assertThat(lottoNumberPackage).isNotNull
        assertThat(lottoNumberPackage.size()).isEqualTo(LottoNumberPackage.LOTTO_GAME_NUMBER_COUNT)
        assertThat(lottoNumberPackage.getSortedNumbers()).isEqualTo(numbers.toSortedSet(compareBy { it }))
    }

    private fun getUnsortedLottoNumbers(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(listOf(2, 4, 5, 1, 6, 3)),
            Arguments.of(listOf(43, 25, 17, 9, 33, 29))
        )
    }

    @ParameterizedTest
    @MethodSource("getMissedRankedGameNumbers")
    fun `당첨번호와 2개 이하의 번호가 일치하는 로또 번호를 입력하면 MISSED LottoResultRank 에 상금은 0원이다`(
        lottoNumbers: List<Int>,
        winningNumbers: List<Int>,
        bonusNumberInput: String
    ) {
        val lottoNumberPackage = LottoNumberPackage(lottoNumbers.map { LottoNumber[it] }.toSet())
        val winningNumberPackage = LottoNumberPackage(winningNumbers.map { LottoNumber[it] }.toSet())
        val winningInfo = WinningInfo(winningNumberPackage, LottoNumber.from(bonusNumberInput, winningNumberPackage))
        val rank = LottoResultRank.getRank(lottoNumberPackage.getMatchedCount(winningInfo.winningNumberPackage), lottoNumberPackage.matchedBonusNumber(winningInfo.bonusNumber))

        assertThat(lottoNumberPackage).isNotNull
        assertThat(lottoNumberPackage.size()).isEqualTo(LottoNumberPackage.LOTTO_GAME_NUMBER_COUNT)
        assertThat(rank).isEqualTo(LottoResultRank.MISSED)
        assertThat(lottoNumberPackage.getPrizeMoney(winningInfo)).isEqualTo(0L)
    }

    private fun getMissedRankedGameNumbers(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(listOf(1, 2, 3, 4, 5, 6), listOf(7, 8, 9, 10, 11, 12), "13"),
            Arguments.of(listOf(1, 2, 3, 4, 5, 6), listOf(1, 8, 9, 10, 11, 12), "13"),
            Arguments.of(listOf(1, 2, 3, 4, 5, 6), listOf(1, 2, 9, 10, 11, 12), "13"),
        )
    }

    @ParameterizedTest
    @MethodSource("getFifthRankedGameNumbers")
    fun `당첨번호와 3개의 번호가 일치하는 로또 번호를 입력하면 FIFTH LottoResultRank 에 상금은 5000원이다`(
        lottoNumbers: List<Int>,
        winningNumbers: List<Int>,
        bonusNumberInput: String
    ) {
        val lottoNumberPackage = LottoNumberPackage(lottoNumbers.map { LottoNumber[it] }.toSet())
        val winningNumberPackage = LottoNumberPackage(winningNumbers.map { LottoNumber[it] }.toSet())
        val winningInfo = WinningInfo(winningNumberPackage, LottoNumber.from(bonusNumberInput, winningNumberPackage))
        val rank = LottoResultRank.getRank(lottoNumberPackage.getMatchedCount(winningInfo.winningNumberPackage), lottoNumberPackage.matchedBonusNumber(winningInfo.bonusNumber))

        assertThat(lottoNumberPackage).isNotNull
        assertThat(lottoNumberPackage.size()).isEqualTo(LottoNumberPackage.LOTTO_GAME_NUMBER_COUNT)
        assertThat(rank).isEqualTo(LottoResultRank.FIFTH)
        assertThat(lottoNumberPackage.getPrizeMoney(winningInfo)).isEqualTo(5000L)
    }

    private fun getFifthRankedGameNumbers(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(listOf(1, 2, 3, 4, 5, 6), listOf(1, 2, 3, 10, 11, 12), "13"),
            Arguments.of(listOf(1, 2, 3, 4, 5, 6), listOf(4, 5, 6, 10, 11, 12), "13"),
            Arguments.of(listOf(1, 2, 3, 4, 5, 6), listOf(1, 3, 5, 10, 11, 12), "13"),
            Arguments.of(listOf(1, 2, 3, 4, 5, 6), listOf(2, 4, 6, 10, 11, 12), "13"),
        )
    }

    @ParameterizedTest
    @MethodSource("getFourthRankedGameNumbers")
    fun `당첨번호와 4개의 번호가 일치하는 로또 번호를 입력하면 FOURTH LottoResultRank 에 상금은 50000원이다`(
        lottoNumbers: List<Int>,
        winningNumbers: List<Int>,
        bonusNumberInput: String
    ) {
        val lottoNumberPackage = LottoNumberPackage(lottoNumbers.map { LottoNumber[it] }.toSet())
        val winningNumberPackage = LottoNumberPackage(winningNumbers.map { LottoNumber[it] }.toSet())
        val winningInfo = WinningInfo(winningNumberPackage, LottoNumber.from(bonusNumberInput, winningNumberPackage))
        val rank = LottoResultRank.getRank(lottoNumberPackage.getMatchedCount(winningInfo.winningNumberPackage), lottoNumberPackage.matchedBonusNumber(winningInfo.bonusNumber))

        assertThat(lottoNumberPackage).isNotNull
        assertThat(lottoNumberPackage.size()).isEqualTo(LottoNumberPackage.LOTTO_GAME_NUMBER_COUNT)
        assertThat(rank).isEqualTo(LottoResultRank.FOURTH)
        assertThat(lottoNumberPackage.getPrizeMoney(winningInfo)).isEqualTo(50000L)
    }

    private fun getFourthRankedGameNumbers(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(listOf(1, 2, 3, 4, 5, 6), listOf(1, 2, 3, 4, 11, 12), "13"),
            Arguments.of(listOf(1, 2, 3, 4, 5, 6), listOf(2, 3, 4, 5, 11, 12), "13"),
            Arguments.of(listOf(1, 2, 3, 4, 5, 6), listOf(3, 4, 5, 6, 11, 12), "13"),
        )
    }

    @ParameterizedTest
    @MethodSource("getThirdRankedGameNumbers")
    fun `당첨번호와 5개의 번호가 일치하고 보너스 번호와 일치하지 않는 로또 번호를 입력하면 THIRD LottoResultRank 에 상금은 1500000원이다`(
        lottoNumbers: List<Int>,
        winningNumbers: List<Int>,
        bonusNumberInput: String
    ) {
        val lottoNumberPackage = LottoNumberPackage(lottoNumbers.map { LottoNumber[it] }.toSet())
        val winningNumberPackage = LottoNumberPackage(winningNumbers.map { LottoNumber[it] }.toSet())
        val winningInfo = WinningInfo(winningNumberPackage, LottoNumber.from(bonusNumberInput, winningNumberPackage))
        val rank = LottoResultRank.getRank(lottoNumberPackage.getMatchedCount(winningInfo.winningNumberPackage), lottoNumberPackage.matchedBonusNumber(winningInfo.bonusNumber))

        assertThat(lottoNumberPackage).isNotNull
        assertThat(lottoNumberPackage.size()).isEqualTo(LottoNumberPackage.LOTTO_GAME_NUMBER_COUNT)
        assertThat(rank).isEqualTo(LottoResultRank.THIRD)
        assertThat(lottoNumberPackage.getPrizeMoney(winningInfo)).isEqualTo(1_500_000L)
    }

    private fun getThirdRankedGameNumbers(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(listOf(1, 2, 3, 4, 5, 6), listOf(1, 2, 3, 4, 5, 12), "13"),
            Arguments.of(listOf(1, 2, 3, 4, 5, 6), listOf(2, 3, 4, 5, 6, 12), "13"),
        )
    }

    @ParameterizedTest
    @MethodSource("getSecondRankedGameNumbers")
    fun `당첨번호와 5개의 번호가 일치하고 보너스 번호와 일치하는 로또 번호를 입력하면 SECOND LottoResultRank 에 상금은 3000000원이다`(
        lottoNumbers: List<Int>,
        winningNumbers: List<Int>,
        bonusNumberInput: String
    ) {
        val lottoNumberPackage = LottoNumberPackage(lottoNumbers.map { LottoNumber[it] }.toSet())
        val winningNumberPackage = LottoNumberPackage(winningNumbers.map { LottoNumber[it] }.toSet())
        val winningInfo = WinningInfo(winningNumberPackage, LottoNumber.from(bonusNumberInput, winningNumberPackage))
        val rank = LottoResultRank.getRank(lottoNumberPackage.getMatchedCount(winningInfo.winningNumberPackage), lottoNumberPackage.matchedBonusNumber(winningInfo.bonusNumber))

        assertThat(lottoNumberPackage).isNotNull
        assertThat(lottoNumberPackage.size()).isEqualTo(LottoNumberPackage.LOTTO_GAME_NUMBER_COUNT)
        assertThat(rank).isEqualTo(LottoResultRank.SECOND)
        assertThat(lottoNumberPackage.getPrizeMoney(winningInfo)).isEqualTo(3_000_000L)
    }

    private fun getSecondRankedGameNumbers(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(listOf(1, 2, 3, 4, 5, 6), listOf(1, 2, 3, 4, 5, 12), "6"),
            Arguments.of(listOf(1, 2, 3, 4, 5, 6), listOf(2, 3, 4, 5, 6, 12), "1"),
        )
    }

    @ParameterizedTest
    @MethodSource("getFirstRankedGameNumbers")
    fun `당첨번호와 6개의 번호가 일치하는 로또 번호를 입력하면 FIRST LottoResultRank 에 상금은 20억원이다`(
        lottoNumbers: List<Int>,
        winningNumbers: List<Int>,
        bonusNumberInput: String
    ) {
        val lottoNumberPackage = LottoNumberPackage(lottoNumbers.map { LottoNumber[it] }.toSet())
        val winningNumberPackage = LottoNumberPackage(winningNumbers.map { LottoNumber[it] }.toSet())
        val winningInfo = WinningInfo(winningNumberPackage, LottoNumber.from(bonusNumberInput, winningNumberPackage))
        val rank = LottoResultRank.getRank(lottoNumberPackage.getMatchedCount(winningInfo.winningNumberPackage), lottoNumberPackage.matchedBonusNumber(winningInfo.bonusNumber))

        assertThat(lottoNumberPackage).isNotNull
        assertThat(lottoNumberPackage.size()).isEqualTo(LottoNumberPackage.LOTTO_GAME_NUMBER_COUNT)
        assertThat(rank).isEqualTo(LottoResultRank.FIRST)
        assertThat(lottoNumberPackage.getPrizeMoney(winningInfo)).isEqualTo(2_000_000_000L)
    }

    private fun getFirstRankedGameNumbers(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(listOf(1, 2, 3, 4, 5, 6), listOf(1, 2, 3, 4, 5, 6), "13"),
            Arguments.of(listOf(7, 8, 9, 10, 11, 12), listOf(7, 8, 9, 10, 11, 12), "13"),
        )
    }

    @ParameterizedTest
    @EmptySource
    fun `당첨 번호에 빈 문자열을 입력하면 IllegalArgumentException이 발생한다`(input: String) {
        Assertions.assertThatThrownBy {
            LottoNumberPackage.from(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "aaa, 1, 2, 3, 4, 5",
            "테스트, 1, 2, 3, 4, 5",
            "!, 1, 2, 3, 4, 5",
            "/, 1, 2, 3, 4, 5"
        ]
    )
    fun `당첨 번호에 숫자가 아닌 값을 입력하면 IllegalArgumentException이 발생한다`(input: String) {
        Assertions.assertThatThrownBy {
            LottoNumberPackage.from(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "1",
            "1, 2",
            "1, 2, 3",
            "1, 2, 3, 4",
            "1, 2, 3, 4, 5",
            "1, 2, 3, 4, 5, 6, 7",
        ]
    )
    fun `당첨 번호가 6개가 아니면 IllegalArgumentException이 발생한다`(input: String) {
        Assertions.assertThatThrownBy {
            LottoNumberPackage.from(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "1, 2, 3, 4, 5, 6",
            "21, 32, 43, 4, 15, 27"
        ]
    )
    fun `당첨 번호가 6개를 입력하면 정상적으로 WinningInfo 가 생성된다`(input: String) {
        val winningInfo = LottoNumberPackage.from(input)

        assertThat(winningInfo).isNotNull
        assertThat(winningInfo.size()).isEqualTo(LottoNumberPackage.LOTTO_GAME_NUMBER_COUNT)
    }
}
