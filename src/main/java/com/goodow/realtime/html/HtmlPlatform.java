/*
 * Copyright 2013 Goodow.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.goodow.realtime.html;

import com.goodow.realtime.core.Handler;
import com.goodow.realtime.core.Net;
import com.goodow.realtime.core.Platform;
import com.goodow.realtime.json.Json;
import com.goodow.realtime.json.JsonObject;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.RepeatingCommand;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;

public class HtmlPlatform extends Platform {
  /**
   * Prepares the HTML platform for operation.
   */
  public static HtmlPlatform register() {
    HtmlPlatform platform = new HtmlPlatform();
    Platform.setPlatform(platform);
    return platform;
  }

  private int timerId = 0;
  private final JsonObject timers = Json.createObject();
  private final HtmlNet net = new HtmlNet();

  protected HtmlPlatform() {
  }

  @Override
  public boolean cancelTimer(int id) {
    if (timers.has("" + id)) {
      timers.remove("" + id);
      return true;
    }
    return false;
  }

  @Override
  public Net net() {
    return net;
  }

  @Override
  public void scheduleDeferred(final Runnable cmd) {
    Scheduler.get().scheduleDeferred(new ScheduledCommand() {
      @Override
      public void execute() {
        cmd.run();
      }
    });
  }

  @Override
  public int setPeriodic(int delayMs, final Handler<Integer> handler) {
    final int id = timerId++;
    RepeatingCommand cmd = new RepeatingCommand() {
      @Override
      public boolean execute() {
        if (timers.has("" + id)) {
          handler.handle(id);
          return true;
        }
        return false;
      }
    };
    timers.set("" + id, cmd);
    Scheduler.get().scheduleFixedPeriod(cmd, delayMs);
    return id;
  }

  @Override
  public Type type() {
    return Type.HTML;
  }
}