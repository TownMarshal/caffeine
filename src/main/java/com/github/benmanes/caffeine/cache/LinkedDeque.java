/*
 * Copyright 2014 Ben Manes. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.benmanes.caffeine.cache;

import java.util.Deque;

import javax.annotation.concurrent.NotThreadSafe;

/**
 * A linked list extension of the {@link Deque} interface where the link pointers are tightly
 * integrated with the element. Linked deques have no capacity restrictions; they grow as necessary
 * to support usage. They are not thread-safe; in the absence of external synchronization, they do
 * not support concurrent access by multiple threads. Null elements are prohibited.
 * <p>
 * Most <tt>LinkedDeque</tt> operations run in constant time by assuming that the element parameter
 * is associated with the deque instance. Any usage that violates this assumption will result in
 * non-deterministic behavior.
 * <p>
 * An element can exist in only one instance of a deque implementation, but may exist in multiple
 * implementations. Each implementation must define unique names for accessing and modifying its
 * link pointers.
 * <p>
 * The iterators returned by this class are <em>not</em> <i>fail-fast</i>: If the deque is modified
 * at any time after the iterator is created, the iterator will be in an unknown state. Thus, in the
 * face of concurrent modification, the iterator risks arbitrary, non-deterministic behavior at an
 * undetermined time in the future.
 *
 * @author ben.manes@gmail.com (Ben Manes)
 * @param <E> the type of elements held in this collection
 */
@NotThreadSafe
interface LinkedDeque<E> extends Deque<E> {

  /**
   * Moves the element to the front of the deque so that it becomes the first element.
   *
   * @param e the linked element
   */
  void moveToFront(E e);

  /**
   * Moves the element to the back of the deque so that it becomes the last element.
   *
   * @param e the linked element
   */
  void moveToBack(E e);

  /**
   * Retrieves the previous element or <tt>null</tt> if either the element is unlinked or the first
   * element on the deque.
   */
  E getPrevious(E e);

  /** Sets the previous element or <tt>null</tt> if there is no link. */
  void setPrevious(E e, E prev);

  /**
   * Retrieves the next element or <tt>null</tt> if either the element is unlinked or the last
   * element on the deque.
   */
  E getNext(E e);

  /** Sets the next element or <tt>null</tt> if there is no link. */
  void setNext(E e, E next);
}