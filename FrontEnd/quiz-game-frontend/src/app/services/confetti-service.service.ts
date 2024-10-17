import { Injectable } from '@angular/core';
import confetti from 'canvas-confetti';

@Injectable({
  providedIn: 'root'
})
export class ConfettiServiceService {

  constructor() { }

  showConfetti() {
    const count = 200; // Número de piezas de confetti
    const defaults = {
      origin: { y: 0.7 }
    };

    // Llama a la función fire con diferentes configuraciones
    this.fireConfetti(count, defaults);
  }

  private fireConfetti(count: number, defaults: any) {
    // Genera el confetti
    function fire(particleRatio: number, opts: any) {
      confetti({
        ...defaults,
        ...opts,
        particleCount: Math.floor(count * particleRatio)
      });
    }

    fire(0.1, { spread: 80, startVelocity: 45, decay: 0.9, scalar: 1.2});
  }
}
