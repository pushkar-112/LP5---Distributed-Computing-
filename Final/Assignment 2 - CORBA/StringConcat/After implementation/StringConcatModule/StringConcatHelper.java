package StringConcatModule;


/**
* StringConcatModule/StringConcatHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from StringConcatModule.idl
* Tuesday, 30 May, 2023 1:50:16 AM IST
*/

abstract public class StringConcatHelper
{
  private static String  _id = "IDL:StringConcatModule/StringConcat:1.0";

  public static void insert (org.omg.CORBA.Any a, StringConcatModule.StringConcat that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static StringConcatModule.StringConcat extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (StringConcatModule.StringConcatHelper.id (), "StringConcat");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static StringConcatModule.StringConcat read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_StringConcatStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, StringConcatModule.StringConcat value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static StringConcatModule.StringConcat narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof StringConcatModule.StringConcat)
      return (StringConcatModule.StringConcat)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      StringConcatModule._StringConcatStub stub = new StringConcatModule._StringConcatStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static StringConcatModule.StringConcat unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof StringConcatModule.StringConcat)
      return (StringConcatModule.StringConcat)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      StringConcatModule._StringConcatStub stub = new StringConcatModule._StringConcatStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
