package com.bizo.gwthack.shared.messages;

import com.bizo.gwthack.shared.model.*;
import java.util.*;
import org.tessell.*;

@GenDispatch
public class SaveClientSpec {
  @In(1)
  ClientDto client;
  @Out(1)
  boolean success;
  @Out(2)
  ArrayList<String> messages;
}
