/*
 * Copyright (C) 2006-2013 Bitronix Software (http://www.bitronix.be)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package bitronix.tm.internal;

/**
 * Subclass of {@link jakarta.transaction.SystemException} indicating a rollback must be performed.
 * This exception is used to handle unilateral rollback of resources during delistement.
 *
 * @author Ludovic Orban
 */
public class BitronixRollbackSystemException extends BitronixSystemException {

    public BitronixRollbackSystemException(String string, Throwable t) {
        super(string, t);
    }

}
