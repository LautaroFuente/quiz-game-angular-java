import { Component, OnInit } from '@angular/core';
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

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [ReactiveFormsModule, FormsModule, RouterModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css',
})
export class RegisterComponent implements OnInit {
  formRegister!: FormGroup;
  name: string = '';
  email: string = '';

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
    this.registerService.saveUser(this.name, this.email).subscribe(
      (response) => console.log('Informacion guardada', response),
      (error) => console.log(`Error al enviar`, error)
    );
    this.router.navigate(['/difficulty']);
  }
}
