/*
 * Copyright (c) 2008 Amazon.com, Inc.  All rights reserved.
 */

package com.amazon.ion.streaming;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * Interface to write Ion value to bytes over a variety of destinations.
 * Avoiding the Java standard overhead in so far as possible.
 * This requires the ability to access any part of the underlying
 * data source randomly and insert space at any position.  However forward 
 * access is expected to be the standard direction.
 */
public interface ByteWriter
{
        public void write(byte b) throws IOException;
        public void write(byte[] dst, int start, int len) throws IOException;
        public int  position();
        public void position(int newPosition);
        
        public void insert(int length);
        public void remove(int length);
        
        public void writeTypeDesc(int typeDescByte) throws IOException;
        public int  writeTypeDescWithLength(int typeid, int valueLenth) throws IOException;
        
        public int  writeLong(long value, boolean force_zero_write) throws IOException;
        public int  writeVarLong(long value, boolean force_zero_write) throws IOException;
        public int  writeVarULong(long value, boolean force_zero_write) throws IOException;

        public int  writeInt(int value, int lenToWrite) throws IOException;
        public int  writeInt(int value, boolean force_zero_write) throws IOException;
        public int  writeVarInt(int value, boolean force_zero_write) throws IOException;
        public int  writeVarUInt(int value, boolean force_zero_write) throws IOException;

        public int  writeFloat(double value) throws IOException;
        public int  writeDecimal(BigDecimal value) throws IOException;
        public int  writeString(String value) throws IOException;
}