package exam1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FinancialCalculatorTest {
    FinancialCalculator calc;
    Scanner scanner;

    static ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        calc = new FinancialCalculator();
        scanner = mock(Scanner.class);
        FinancialCalculator.scanner = scanner;
        Arrays.fill(FinancialCalculator.spendingList, BigDecimal.valueOf(-1));
        FinancialCalculator.spendingList[0] = BigDecimal.valueOf(50.5);
        FinancialCalculator.spendingList[1] = BigDecimal.valueOf(100.25);
    }

    @Test
    public void testSetDaySpending() {
        when(scanner.nextInt()).thenReturn(5).thenReturn(0);
        when(scanner.nextBigDecimal()).thenReturn(BigDecimal.valueOf(1.23));
        calc.setDaySpending();
        assertEquals(BigDecimal.valueOf(1.23), FinancialCalculator.spendingList[4]);
        FinancialCalculator.spendingList[4] = BigDecimal.valueOf(0);
    }

    @Test
    public void testShowMonthSpending() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        calc.showMonthSpending();
        assertEquals("\n---Вывод всех трат по дням за месяц---\n1-й день: 50.50 руб\n2-й день: 100.25 руб\n3-й день: не установлено\n4-й день: не установлено\n5-й день: не установлено\n6-й день: не установлено\n7-й день: не установлено\n8-й день: не установлено\n9-й день: не установлено\n10-й день: не установлено\n11-й день: не установлено\n12-й день: не установлено\n13-й день: не установлено\n14-й день: не установлено\n15-й день: не установлено\n16-й день: не установлено\n17-й день: не установлено\n18-й день: не установлено\n19-й день: не установлено\n20-й день: не установлено\n21-й день: не установлено\n22-й день: не установлено\n23-й день: не установлено\n24-й день: не установлено\n25-й день: не установлено\n26-й день: не установлено\n27-й день: не установлено\n28-й день: не установлено\n29-й день: не установлено\n30-й день: не установлено\n",outContent.toString());
    }

    @Test
    public void testGetBiggestDecimal() {
        assertEquals(1, calc.getBiggestDecimal());
    }

    @Test
    public void testGetBiggestDay() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        calc.getBiggestDay();
        Assert.assertEquals("\n---Самая большая сумма---\n2-й день: 100.25 руб\n", outContent.toString());
    }

    @Test
    public void testGetConvertedSum() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        calc.getConvertedSum();
        assertEquals("\n---Сумма затрат в других валютах---\nВ долларах: $1.66\nВ евро: €1.51\nВ юанях: ¥11.91\n", outContent.toString());
    }
}
