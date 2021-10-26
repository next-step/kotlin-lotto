package domain.calculator.domain.separator

@JvmInline
value class Separators private constructor(private val separators: Set<Separator>) {
// seperator ->
// 구분자랑 숫자를 분리하는 작업이 잇으면 좋을 것 같은데
// separators -> 문자열 입력 받으면 ->
// //;\n1;2;3
// Expression -> hasCustom(); -> true -> 그냥 계산
// Expression -> hasCustom(); -> false -> 커스텀 계싼해서 계산
// 팩토리 메서드 다르게 해서 -> true면 기본으로 생성하고, false 면 커스텀 만들어야할듯

    companion object {
        fun of(separators: Set<Separator>) = Separators(separators.toSet())
    }
}
