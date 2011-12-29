package com.bizo.gwthack.shared.messages;

import com.bizo.gwthack.shared.model.*;
import java.util.*;
import org.tessell.*;

@GenDispatch
public class GetClientsSpec {
  @In(1)
  Integer start;
  @In(2)
  Integer end;
  @Out(1)
  ArrayList<ClientDto> clients;
}
