package CalculatorModule;

/**
* CalculatorModule/CalculatorHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CalculatorModule.idl
* Tuesday, 30 May, 2023 2:00:20 AM IST
*/

public final class CalculatorHolder implements org.omg.CORBA.portable.Streamable
{
  public CalculatorModule.Calculator value = null;

  public CalculatorHolder ()
  {
  }

  public CalculatorHolder (CalculatorModule.Calculator initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = CalculatorModule.CalculatorHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    CalculatorModule.CalculatorHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return CalculatorModule.CalculatorHelper.type ();
  }

}