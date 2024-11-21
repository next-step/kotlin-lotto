import lotto.domain.LottoNumber

class WinningLotto(
    val lottoNumbers: List<LottoNumber>,
    val bonusNumber: LottoNumber,
) {
    init {
        require(lottoNumbers.size == 6) {
            "로또 번호는 6개여야 합니다."
        }

        require(bonusNumber !in lottoNumbers) {
            "보너스 번호는 당첨 번호와 중복되면 안됩니다. bonusNumber = $bonusNumber"
        }
    }
}
