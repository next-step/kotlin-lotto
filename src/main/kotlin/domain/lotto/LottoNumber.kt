package domain.lotto

enum class LottoNumber(val value: Int) : Comparable<LottoNumber> {
    N01(1),
    N02(2),
    N03(3),
    N04(4),
    N05(5),
    N06(6),
    N07(7),
    N08(8),
    N09(9),
    N10(10),
    N11(11),
    N12(12),
    N13(13),
    N14(14),
    N15(15),
    N16(16),
    N17(17),
    N18(18),
    N19(19),
    N20(20),
    N21(21),
    N22(22),
    N23(23),
    N24(24),
    N25(25),
    N26(26),
    N27(27),
    N28(28),
    N29(29),
    N30(30),
    N31(31),
    N32(32),
    N33(33),
    N34(34),
    N35(35),
    N36(36),
    N37(37),
    N38(38),
    N39(39),
    N40(40),
    N41(41),
    N42(42),
    N43(43),
    N44(44),
    N45(45),
    ;

    companion object {
        val VALUES: List<LottoNumber> = values().toList()

        private val lottoNumbersByInteger: Map<Int, LottoNumber> = VALUES.associateBy { it.value }

        fun parse(value: Int): LottoNumber {
            return requireNotNull(lottoNumbersByInteger[value])
        }
    }
}
