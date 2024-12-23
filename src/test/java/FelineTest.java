import com.example.Animal;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    Feline spyFeline;

    @Test
    public void getFamilyTest() {
        Feline feline = new Feline();
        String actual = feline.getFamily();
        Assert.assertEquals("Семейство кошачьи должно называться Кошачьи", "Кошачьи", actual);
    }

    @Test
    public void eatMeatRunPredatorTest() throws Exception {
        spyFeline.eatMeat();
        Mockito.verify(spyFeline, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void getKittensByCountTest() {
        Feline feline = new Feline();
        int expected = 3;
        int actual = feline.getKittens(expected);
        Assert.assertEquals("Котят должно быть сколько передали", expected, actual);
    }

    @Test
    public void getKittensNoParamInvokeGetKittensWith1() {
        spyFeline.getKittens();
        Mockito.verify(spyFeline, Mockito.times(1)).getKittens(1);
    }
}
