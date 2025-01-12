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

import javax.transaction.xa.XAException;

/**
 * Subclass of {@link javax.transaction.xa.XAException} supporting nested {@link Throwable}s.
 *
 * @author Ludovic Orban
 */
public class BitronixXAException extends XAException {

    public BitronixXAException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public BitronixXAException(String message, int errorCode, Throwable t) {
        super(message);
        this.errorCode = errorCode;
        initCause(t);
    }

    public static boolean isUnilateralRollback(XAException ex) {
        return (ex.errorCode >= XAException.XA_RBBASE && ex.errorCode <= XAException.XA_RBEND) || ex.errorCode == XAException.XAER_NOTA;
    }

}
