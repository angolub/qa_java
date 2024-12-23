import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@RunWith(Parameterized.class)
public class LionHaveManeTest {
    private final String sex;
    private final boolean hasMane;
    private final boolean hasException;
    private final String exceptionMessage;

    @Mock
    private Feline feline;

    public LionHaveManeTest(
            String sex,
            boolean hasMane,
            boolean hasException,
            String exceptionMessage
    ){
        this.sex = sex;
        this.hasMane = hasMane;
        this.hasException = hasException;
        this.exceptionMessage = exceptionMessage;
    }
    
    @Parameterized.Parameters
    public static Object[][] getLionData() {
        return new Object[][]{
                {
                        "Самец",
                        true,
                        false,
                        ""
                },
                {
                        "Самка",
                        false,
                        false,
                        ""
                },
                {
                        "Неизвестно",
                        false,
                        true,
                        "Используйте допустимые значения пола животного - самей или самка"
                }
        };
    }

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void doesHaveManeTest()  {
        try {
            Lion lion = new Lion(this.sex, feline);
            boolean actual = lion.doesHaveMane();
            Assert.assertEquals(this.hasMane, actual);
        } catch (Exception ex) {
            if (this.hasException) {
                Assert.assertEquals(this.exceptionMessage, ex.getMessage());
            } else {
                Assert.assertNull(ex);
            }
        }
    }
}
