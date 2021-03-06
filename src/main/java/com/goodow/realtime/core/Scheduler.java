/*
 * Copyright 2014 Goodow.com
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
package com.goodow.realtime.core;

/**
 * This class provides low-level task scheduling primitives.
 */
public interface Scheduler {
  /**
   * Cancel the timer with the specified {@code id}. Returns {@code} true if the timer was
   * successfully cancelled, or {@code false} if the timer does not exist.
   */
  boolean cancelTimer(int id);

  void handle(Object handler, Object event);

  /**
   * A deferred command is executed after the event loop returns.
   */
  void scheduleDeferred(Handler<Void> handler);

  /**
   * Set a one-shot timer to fire after {@code delayMs} milliseconds, at which point {@code handler}
   * will be called.
   * 
   * @return the unique ID of the timer
   */
  int scheduleDelay(int delayMs, Handler<Void> handler);

  /**
   * Schedules a repeating handler that is scheduled with a constant periodicity. That is, the
   * handler will be invoked every <code>delayMs</code> milliseconds, regardless of how long the
   * previous invocation took to complete.
   * 
   * @param delayMs the period with which the handler is executed
   * @param handler the handler to execute
   * 
   * @return the unique ID of the timer
   */
  int schedulePeriodic(int delayMs, Handler<Void> handler);
}
