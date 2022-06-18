# kotlin-lotto

## 문자열 덧셈 계산기

### 기능 요구사항

- [x] 쉼표(,) 또는 콜론(:)을 구분자로 구분
- [ ] 커스텀 구분자를 만들 수 있음
  - [ ] 커스텀 구분자는 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 함
- [x] 문자를 숫자로 변환
  - [ ] 숫자가 아닌 문자 혹은 음수를 전달할 경우 RuntimeException 발생
- [x] 모든 숫자의 합을 구함
  - [x] 빈 문자열 혹은 null이 들어온 경우 0을 반환
  - [x] 숫자만 들어온 경우 해당 숫자를 반환