PropertyFileReader
- Make intermediate directories if needed

Calculator
- DIV by 0 --> throw error (because no answer is correct)

CalculationsTest
- Test to catch error if DIV by 0

PropertiesTest
- assertArrayEquals gives InvocationTargetException (Inner details: suppressedExceptions Collections$UnmodifiableRandomAccessList<E>)

RandomizerTest
- Deleted magic chars from test_Random_Element_From_CharArray
- Deleted magic strings from test_Random_Element_From_StringArray
- Made test numbers completely random for test_Get_Random_Element_Equal_Boundaries_Expect_Same_Number
- Tests on getRandomNumber have to allow both the min and max to be result

Randomizer
- getRandomNumber: randomNumber + minNumber
- getRandomNumber: Overload for double + nrDecimals
