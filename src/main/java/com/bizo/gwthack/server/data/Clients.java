package com.bizo.gwthack.server.data;

import java.util.ArrayList;
import java.util.List;

import com.bizo.gwthack.shared.model.GClientDto;

public class Clients {

  private static List<GClientDto> clients = new ArrayList<GClientDto>();

  public static List<GClientDto> get() {
    return clients;
  }

  public static GClientDto get(final String id) {
    for (final GClientDto c : clients) {
      if (c.id.equals(id)) {
        return c;
      }
    }
    return null;
  }

  static {
    for (int i = 0; i < 15; i++) {
      final GClientDto client = new GClientDto();
      client.id = String.valueOf(i);
      client.name = "Client " + i;
      clients.add(client);
    }
  }

}
