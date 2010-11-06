package com.bizo.gwthack.server.data;

import com.bizo.gwthack.shared.model.*;
import java.util.*;

/** Fake server-side data store. */
public class Clients {

  private static List<ClientDto> clients = new ArrayList<ClientDto>();

  public static List<ClientDto> get() {
    return clients;
  }

  public static ClientDto get(final String id) {
    for (final ClientDto c : clients) {
      if (c.id.equals(id)) {
        return c;
      }
    }
    return null;
  }

  static {
    for (int i = 0; i < 15; i++) {
      final ClientDto client = new ClientDto();
      client.id = String.valueOf(i);
      client.name = "Client " + i;
      clients.add(client);
    }
  }

}
