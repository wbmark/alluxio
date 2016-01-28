/*
 * Licensed to the University of California, Berkeley under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for additional information regarding
 * copyright ownership. The ASF licenses this file to You under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package tachyon.master.journal;

import java.io.IOException;

import tachyon.proto.journal.Journal.JournalEntry;

/**
 * This output stream writes {@link JournalEntry} objects to the journal. This output stream can
 * write to both the journal checkpoint file, or the journal log files.
 */
public interface JournalOutputStream {
  /**
   * Writes a {@link JournalEntry} to the journal.
   *
   * @param entry the entry to write to the journal
   * @throws IOException if an I/O error occurs
   */
  void writeEntry(JournalEntry entry) throws IOException;

  /**
   * Closes the stream.
   *
   * @throws IOException if an I/O error occurs
   */
  void close() throws IOException;

  /**
   * Flushes the stream.
   *
   * @throws IOException if an I/O error occurs
   */
  void flush() throws IOException;
}