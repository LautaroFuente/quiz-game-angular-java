import { Component, OnInit, OnDestroy } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  FormsModule,
  Validators,
} from '@angular/forms';
import { GameServiceService } from '../../services/game-service.service';
import { Router } from '@angular/router';
import { RouterModule } from '@angular/router';
import { RegisterServiceService } from '../../services/register-service.service';
import { takeUntil } from 'rxjs/operators';
import { Subject } from 'rxjs';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [ReactiveFormsModule, FormsModule, RouterModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css',
})
export class RegisterComponent implements OnInit, OnDestroy {
  formRegister!: FormGroup;
  name: string = '';
  email: string = '';

  private unsubscribe$ = new Subject<void>();

  constructor(
    private fb: FormBuilder,
    private gameService: GameServiceService,
    private router: Router,
    private registerService: RegisterServiceService
  ) {}

  ngOnInit() {
    this.formRegister = this.fb.group({
      name: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
    });
  }

  onSubmit() {
    this.gameService.setUserName(this.name);
    this.gameService.setUserEmail(this.email);
    this.registerService.saveUser(this.name, this.email).pipe(takeUntil(this.unsubscribe$)).subscribe(
      (response) => console.log('Informacion guardada', response),
      (error) => console.log(`Error al enviar`, error)
    );
    this.router.navigate(['/difficulty']);
  }

  ngOnDestroy(): void {
    this.unsubscribe$.next();
    this.unsubscribe$.complete();
  }
}
