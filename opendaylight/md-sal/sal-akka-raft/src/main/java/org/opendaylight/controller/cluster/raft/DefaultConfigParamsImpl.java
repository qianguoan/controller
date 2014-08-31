/*
 * Copyright (c) 2014 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.controller.cluster.raft;

import scala.concurrent.duration.FiniteDuration;

import java.util.concurrent.TimeUnit;

/**
 * Default implementation of the ConfigParams
 *
 * If no implementation is provided for ConfigParams, then this will be used.
 */
public class DefaultConfigParamsImpl implements ConfigParams {

    private static final int SNAPSHOT_BATCH_COUNT = 20000;

    private static final int JOURNAL_RECOVERY_LOG_BATCH_SIZE = 1000;

    /**
     * The maximum election time variance
     */
    private static final int ELECTION_TIME_MAX_VARIANCE = 100;

    private static final int SNAPSHOT_CHUNK_SIZE = 2048 * 1000; //2MB


    /**
     * The interval at which a heart beat message will be sent to the remote
     * RaftActor
     * <p/>
     * Since this is set to 100 milliseconds the Election timeout should be
     * at least 200 milliseconds
     */
    public static final FiniteDuration HEART_BEAT_INTERVAL =
        new FiniteDuration(100, TimeUnit.MILLISECONDS);


    private FiniteDuration heartBeatInterval = HEART_BEAT_INTERVAL;
    private long snapshotBatchCount = SNAPSHOT_BATCH_COUNT;
    private int journalRecoveryLogBatchSize = JOURNAL_RECOVERY_LOG_BATCH_SIZE;

    public void setHeartBeatInterval(FiniteDuration heartBeatInterval) {
        this.heartBeatInterval = heartBeatInterval;
    }

    public void setSnapshotBatchCount(long snapshotBatchCount) {
        this.snapshotBatchCount = snapshotBatchCount;
    }

    public void setJournalRecoveryLogBatchSize(int journalRecoveryLogBatchSize) {
        this.journalRecoveryLogBatchSize = journalRecoveryLogBatchSize;
    }

    @Override
    public long getSnapshotBatchCount() {
        return snapshotBatchCount;
    }

    @Override
    public FiniteDuration getHeartBeatInterval() {
        return heartBeatInterval;
    }

    @Override
    public FiniteDuration getElectionTimeOutInterval() {
        // returns 2 times the heart beat interval
        return getHeartBeatInterval().$times(2);
    }

    @Override
    public int getElectionTimeVariance() {
        return ELECTION_TIME_MAX_VARIANCE;
    }

    @Override
    public int getSnapshotChunkSize() {
        return SNAPSHOT_CHUNK_SIZE;
    }

    @Override
    public int getJournalRecoveryLogBatchSize() {
        return journalRecoveryLogBatchSize;
    }
}
