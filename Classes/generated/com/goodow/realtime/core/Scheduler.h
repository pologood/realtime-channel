//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: /Users/retechretech/dev/workspace/realtime/realtime-channel/src/main/java/com/goodow/realtime/core/Scheduler.java
//
//  Created by retechretech.
//

#ifndef _ComGoodowRealtimeCoreScheduler_H_
#define _ComGoodowRealtimeCoreScheduler_H_

@protocol ComGoodowRealtimeCoreHandler;

#import "JreEmulation.h"

@protocol ComGoodowRealtimeCoreScheduler < NSObject, JavaObject >
- (BOOL)cancelTimerWithInt:(int)id_;
- (void)handleWithId:(id)handler
              withId:(id)event;
- (void)scheduleDeferredWithComGoodowRealtimeCoreHandler:(id<ComGoodowRealtimeCoreHandler>)handler;
- (int)scheduleDelayWithInt:(int)delayMs
withComGoodowRealtimeCoreHandler:(id<ComGoodowRealtimeCoreHandler>)handler;
- (int)schedulePeriodicWithInt:(int)delayMs
withComGoodowRealtimeCoreHandler:(id<ComGoodowRealtimeCoreHandler>)handler;
@end

#endif // _ComGoodowRealtimeCoreScheduler_H_