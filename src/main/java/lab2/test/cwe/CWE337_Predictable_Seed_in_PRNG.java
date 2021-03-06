/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE336_Same_Seed_in_PRNG__basic_01.java
Label Definition File: CWE336_Same_Seed_in_PRNG__basic.label.xml
Template File: point-flaw-01.tmpl.java
*/
/*
* @description
* CWE: 336 Same Seed in PRNG
* Sinks:
*    GoodSink: no explicit seed specified
*    BadSink : hardcoded seed
* Flow Variant: 01 Baseline
*
* */

package lab2.test.cwe;

import lab2.test.cwe.testcasesupport.AbstractTestCase;
import lab2.test.cwe.testcasesupport.IO;

import java.security.SecureRandom;

/*
 * http://cwe.mitre.org/data/definitions/337.html
 *
 * Note these examples also exhibit CWE-338 (Use of Cryptographically Weak PRNG).
 */
public class CWE337_Predictable_Seed_in_PRNG extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        SecureRandom secureRandom = new SecureRandom();

        /* FLAW: An attacker can easily predict the seed used by these PRNGs,
        and so also predict the stream of random numbers generated */
        secureRandom.setSeed(System.currentTimeMillis());

        IO.writeLine("" + secureRandom.nextInt());
        IO.writeLine("" + secureRandom.nextInt());

    }

    public void good() throws Throwable
    {
        good1();
    }

    private void good1() throws Throwable
    {

        SecureRandom secureRandom = new SecureRandom();

        /* FIX: no explicit seed specified; produces far less predictable PRNG sequence */

        IO.writeLine("" + secureRandom.nextInt());
        IO.writeLine("" + secureRandom.nextInt());

    }

    /* Below is the main(). It is only used when building this testcase on
     * its own for testing or for building a binary to use in testing binary
     * analysis tools. It is not used when compiling all the testcases as one
     * application, which is how source code analysis tools are tested.
     */
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }
}

